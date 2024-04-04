package ec.sasf.pruebaricardovelastegui.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.sasf.pruebaricardovelastegui.Entity.Recluso;
import ec.sasf.pruebaricardovelastegui.Repository.ReclusoRepository;

@Service
public class ReclusoService {

    @Autowired
    ReclusoRepository  reclusoRepository;

    public Recluso agregarrecluso(Recluso recluso){
        return reclusoRepository.save(recluso);
    }

    //ya está
    public void borrarrecluso(Long id){
        reclusoRepository.deleteById(id);
    }

    //ya está
    public List<Recluso> obtenerreclusos(){
        return reclusoRepository.findAll();
    }

    public Recluso buscarReclusoporId(Long id){

        return reclusoRepository.findById(id).orElse(null);
    }

    public Recluso filtrarReclusosPorNombre(String nombre){
        return reclusoRepository.findByNombre(nombre);
    }


    //ya está
    public Recluso actualizardeRecluso(Long id, Recluso celdaactualizar){
        Optional<Recluso> optionalRecluso = reclusoRepository.findById(id);
        if (optionalRecluso.isPresent()){
            Recluso recluso = optionalRecluso.get();
            recluso.setNombre(celdaactualizar.getNombre());
            recluso.setCelda(celdaactualizar.getCelda());
            return reclusoRepository.save(recluso);
        } else{
            throw new RuntimeException("recluso no encontrado con ID: "+ id);
        }
       
    }
    
}

package ec.sasf.pruebaricardovelastegui.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ec.sasf.pruebaricardovelastegui.Entity.Recluso;
import ec.sasf.pruebaricardovelastegui.Service.ReclusoService;

@RestController
@RequestMapping("/recluso")
@CrossOrigin( origins="http://localhost:4200/" )
public class ReclusoController {

    @Autowired
    private ReclusoService reclusoService;

    @PostMapping("/agregar")
    public Recluso agregarrecluso(@RequestBody Recluso recluso){
        return reclusoService.agregarrecluso(recluso);
    }

    @DeleteMapping("/borrar/{id}")
    public void borrarrecluso(@PathVariable Long id){
        reclusoService.borrarrecluso(id);
    }

    @GetMapping("/obtener")
    @ResponseBody
    public List<Recluso> obtenerreclusos(){
        return reclusoService.obtenerreclusos();
    }

    @GetMapping("/obtener/{id}")
    @ResponseBody
    public Recluso buscarReclusoporId(@PathVariable Long id){
        return reclusoService.buscarReclusoporId(id);
    }

    @GetMapping("/filtrar")
    @ResponseBody
    public ResponseEntity<Recluso> filtrarReclusosPorNombre(@RequestParam String nombre){
        Recluso recluso = reclusoService.filtrarReclusosPorNombre(nombre);
        if(recluso != null){
            return ResponseEntity.ok(recluso);
        } else{
            return ResponseEntity.notFound().build();
        }
    }
   

    @PutMapping("/modificar/{id}")
    public Recluso actualizardeRecluso(@PathVariable Long id, @RequestBody Recluso reclusoactualizar){
        return reclusoService.actualizardeRecluso(id, reclusoactualizar);
    }
    
}

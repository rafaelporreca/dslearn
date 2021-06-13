package br.com.rafaelporreca.dslearn.resources;

import br.com.rafaelporreca.dslearn.dtos.DeliverRevisionDTO;
import br.com.rafaelporreca.dslearn.servicies.DeliverSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deliveries")
public class DeliverResourece {

    private DeliverSerivce serivce;

    @Autowired
    public DeliverResourece(DeliverSerivce serivce) {
        this.serivce = serivce;
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'INSTRUCTOR')")
    @PutMapping("/{id}")
    public ResponseEntity<Void> saveRevision(@PathVariable Long id, @RequestBody DeliverRevisionDTO dto){
        serivce.saveRevision(id,dto);
        return ResponseEntity.noContent().build();
    }
}

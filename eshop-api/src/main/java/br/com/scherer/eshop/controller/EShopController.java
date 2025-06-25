package br.com.scherer.eshop.controller;

import br.com.scherer.eshop.dto.EShopDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("eshop")
public class EShopController {

    @PostMapping
    public ResponseEntity<EShopDTO> cadastrar(@RequestBody EShopDTO eShopDTO) {
        return ResponseEntity.ok(eShopDTO);
    }
}

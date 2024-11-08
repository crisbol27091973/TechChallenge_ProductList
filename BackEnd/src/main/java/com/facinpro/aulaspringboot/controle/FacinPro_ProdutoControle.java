package com.facinpro.aulaspringboot.controle;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.facinpro.aulaspringboot.dtos.FacinPro_ProdutoRecordDto;
import com.facinpro.aulaspringboot.modelo.Facinpro_ProdutoModelo;
import com.facinpro.aulaspringboot.repositorio.FacinPro_ProdutoRepositorio;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
public class FacinPro_ProdutoControle {
    
    @Autowired
    FacinPro_ProdutoRepositorio facinPro_ProdutoRepositorio;
 
    @PostMapping("/products")
	public ResponseEntity<Facinpro_ProdutoModelo> saveProduct(@RequestBody @Valid FacinPro_ProdutoRecordDto facinpro_ProdutoRecordDto) {
	    var facinpro_ProdutoModelo = new Facinpro_ProdutoModelo();

		BeanUtils.copyProperties(facinpro_ProdutoRecordDto, facinpro_ProdutoModelo);
		return ResponseEntity.status(HttpStatus.CREATED).body(facinPro_ProdutoRepositorio.save(facinpro_ProdutoModelo));
	
	}

	
	@GetMapping("/products")
	public ResponseEntity<List<Facinpro_ProdutoModelo>> getAllProducts(){

	  return ResponseEntity.status(HttpStatus.OK).body(facinPro_ProdutoRepositorio.findAll());
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Object> getOneProduct(@PathVariable UUID id){
		Optional<Facinpro_ProdutoModelo> productO = facinPro_ProdutoRepositorio.findById(id);
		if(productO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(productO.get());
	}

    @DeleteMapping("/products/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable UUID id) {
		Optional<Facinpro_ProdutoModelo> productO = facinPro_ProdutoRepositorio.findById(id);
		if(productO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
		}
		facinPro_ProdutoRepositorio.delete(productO.get());
		return ResponseEntity.status(HttpStatus.OK).body("Produto excluído com sucesso.");
	}

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable UUID id, @RequestBody @Valid FacinPro_ProdutoRecordDto facinpro_ProdutoRecordDto) {
		Optional<Facinpro_ProdutoModelo> productO = facinPro_ProdutoRepositorio.findById(id);
		if(productO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto nâo encontrado.");
		}
		var facinpro_ProdutoModelo = productO.get();
		BeanUtils.copyProperties(facinpro_ProdutoRecordDto, facinpro_ProdutoModelo);
		return ResponseEntity.status(HttpStatus.OK).body(facinPro_ProdutoRepositorio.save(facinpro_ProdutoModelo));
	}
  
} 

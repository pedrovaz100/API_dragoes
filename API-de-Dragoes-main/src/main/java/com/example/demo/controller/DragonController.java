package com.example.demo.controller;

import com.example.demo.model.Dragao;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dragons")
@CrossOrigin("*")
public class DragonController {

    private final List<Dragao> dragoes = new ArrayList<>();
    private Long proximoId = 2L;

    public DragonController() {
        dragoes.add(Dragao.builder()
                .id(1L)
                .nome("Ignis")
                .cor("Vermelho")
                .poderDeFogo(950)
                .peso(3500.5)
                .altura(18.7)
                .possuiMontador(true)
                .build());
    }

    @GetMapping
    public List<Dragao> listar() {
        return dragoes;
    }

    @GetMapping("/{id}")
    public Dragao buscarPorId(@PathVariable Long id) {
        return dragoes.stream()
                .filter(dragao -> id.equals(dragao.getId()))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dragão não encontrado."));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dragao criar(@RequestBody Dragao dragao) {
        dragao.setId(proximoId++);
        dragoes.add(dragao);
        return dragao;
    }

    @PutMapping("/{id}")
    public Dragao atualizar(@PathVariable Long id, @RequestBody Dragao dragaoAtualizado) {
        for (int i = 0; i < dragoes.size(); i++) {
            if (id.equals(dragoes.get(i).getId())) {
                dragaoAtualizado.setId(id);
                dragoes.set(i, dragaoAtualizado);
                return dragaoAtualizado;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Dragão não encontrado.");
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        Dragao dragao = dragoes.stream()
                .filter(item -> id.equals(item.getId()))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dragão não encontrado."));

        dragoes.remove(dragao);
    }
}
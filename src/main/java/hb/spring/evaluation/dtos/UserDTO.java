package hb.spring.evaluation.dtos;

import hb.spring.evaluation.models.Category;

import java.util.List;

public record UserDTO(Integer id, String username, List<Category> categories) {
}

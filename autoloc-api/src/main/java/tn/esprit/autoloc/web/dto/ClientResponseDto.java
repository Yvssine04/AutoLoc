package tn.esprit.autoloc.web.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDto {
    private Long idClient;
    private String nom;
    private String prenom;
    private String telephone;
}
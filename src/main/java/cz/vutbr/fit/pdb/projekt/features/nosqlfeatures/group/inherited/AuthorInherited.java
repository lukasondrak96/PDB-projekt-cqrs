package cz.vutbr.fit.pdb.projekt.features.nosqlfeatures.group.inherited;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorInherited {
    private String name;
    private String surname;
}
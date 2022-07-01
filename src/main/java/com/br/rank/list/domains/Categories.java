package com.br.rank.list.domains;

import java.io.Serializable;
import java.util.Collection;

public record Categories(
        Collection<String> values
) implements Serializable {
}

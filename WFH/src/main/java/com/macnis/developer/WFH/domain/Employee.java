package com.macnis.developer.WFH.domain;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Employee {

    @Id @GeneratedValue
    @GraphQLQuery(name = "id", description = "An Employee's technical id.")
    private Long id;
    @GraphQLQuery(name = "name", description = "An Employee's name.")
    private @NotNull String name;
}

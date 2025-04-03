package in.main.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = {"name"}) // We can use only @EqualsAndHashCode if no need to compare value with a particular field level 

public class User {
	private String name;
	private int age;

}

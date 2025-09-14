package constants;

import java.util.List;

public enum AnimalKind {
    HERBIVORE("Травоядное", List.of("Трава", "Различные растения")),
    PREDATOR("Хищник", List.of("Животные", "Птицы", "Рыба"));

    private final String animalKind;
    private final List<String> listFood;

    AnimalKind(String animalKind, List<String> listFood) {
        this.animalKind = animalKind;
        this.listFood = listFood;
    }

    public String getAnimalKind() {
        return animalKind;
    }

    public List<String> getListFood() {
        return listFood;
    }
}

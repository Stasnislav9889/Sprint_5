package constants;

public enum AnimalGender {
    MALE("Самец", true),
    FEMALE("Самка", false);

    private  final String gender;
    private final boolean hasMane;

    AnimalGender(String gender, boolean hasMane) {
        this.gender = gender;
        this.hasMane = hasMane;
    }

    public String getGender() {
        return gender;
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

}

package ss11_stack_quece.bai_tap.bai_tap_7;

public class Record {
    String name;
    String gender;
    String birthDate;

    public Record(String name, String gender, String birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return name + " " + gender + " " + birthDate;
    }
}


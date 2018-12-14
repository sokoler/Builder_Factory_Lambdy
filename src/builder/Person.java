package builder;

public class Person {

    private String pesel;
    private String imie;
    private String nazwisko;
    private int wiek;

    private Person(String pesel) {
        this.pesel = pesel;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pesel='" + pesel + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", wiek=" + wiek +
                '}';
    }

    public static final class PersonBuilder {
        private String pesel;
        private String imie;
        private String nazwisko;
        private int wiek;

        private PersonBuilder(String pesel) {
            this.pesel = pesel;
        }

        public static PersonBuilder aPerson(String pesel) {
            return new PersonBuilder(pesel);
        }

        public PersonBuilder withImie(String imie) {
            this.imie = imie;
            return this;
        }

        public PersonBuilder withNazwisko(String nazwisko) {
            this.nazwisko = nazwisko;
            return this;
        }

        public PersonBuilder withWiek(int wiek) {
            this.wiek = wiek;
            return this;
        }

        public Person build() {
            Person person = new Person(pesel);
            person.setImie(imie);
            person.setNazwisko(nazwisko);
            person.setWiek(wiek);
            return person;
        }


    }
}

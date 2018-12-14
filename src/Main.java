import builder.Person;
import factory.Vehicle;
import factory.VehicleFactoryEnum;
import factory.VehicleFactoryFactory;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


        Vehicle[] vehicles = new Vehicle[3];


        vehicles [0] = VehicleFactoryFactory.getInstance().getVehicle(VehicleFactoryEnum.CAR);
        vehicles [1] = VehicleFactoryFactory.getInstance().getVehicle(VehicleFactoryEnum.PLANE);
        vehicles [2] = VehicleFactoryFactory.getInstance().getVehicle(VehicleFactoryEnum.SHIP);

        for(Vehicle v: vehicles){

            System.out.println(v);

        }

        Arrays.stream(vehicles).forEach(Vehicle::start);

        for (VehicleFactoryEnum en : VehicleFactoryEnum.values()) {

            System.out.println(en);

        }


        Person person2 = Person.PersonBuilder.aPerson("202002022").build();
        Person person3 = Person.PersonBuilder.aPerson("202002022").withImie("Michał").withNazwisko("Sokołowski").build();
        Person person4 = Person.PersonBuilder.aPerson("202002022").withImie("Michał").withNazwisko("Sokołowski").withWiek(22).build();


        Person [] people = { person2,person3,person4};

        Arrays.stream(people).forEach(System.out::println);


        //LAMBDY


        MyInterface myAnonymousImplementation = new MyInterface() {
            @Override
            public String go(String s,String s2, int a) {
                return "Implementacja w anonimowej klasie " + s + s2 + a;
            }
        };

        MyInterface myLambda = ((s,s2, a) -> "Implementacja lambda " + s +s2 + a );
        //myLambda.go("siema", 1);

        System.out.println(myLambda.go("siema","heniu", 1));

        useClassOrLambdaOrAnonymousInterface(new MyFirstImplementation(), "siema ", 1);
        useClassOrLambdaOrAnonymousInterface(myAnonymousImplementation, "elo ", 2);
        useClassOrLambdaOrAnonymousInterface(myLambda, "cześć ", 3);
        useClassOrLambdaOrAnonymousInterface((s,s2, a) -> s + a + "anonimowa lambda", "hejo", 4);


    }


    static void useClassOrLambdaOrAnonymousInterface(MyInterface myInterface, String s, int i){

        System.out.println( myInterface.go(s,s,i));

    }


}

@FunctionalInterface
interface MyInterface {    // functional interface moze zawierac tylko 1 metodę

    String go(String s ,String s2, int a);

}

class MyFirstImplementation implements MyInterface{

    @Override
    public String go(String s, String s2, int a) {
        return "Implementacja w zwykłej klasie " + s + a;
    }
}


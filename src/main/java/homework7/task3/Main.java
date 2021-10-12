package homework7.task3;

public class Main {
    public static void main(String[] args) {
        Eagle eagle = new Eagle(10, true, "golden eagle", 20);

        Eagle eagleClonedWithCloneMethod = eagle.clone();

        System.out.println("Source: " + eagle);
        System.out.println("Cloned with clone(): " + eagleClonedWithCloneMethod);

        Eagle eagleClonedWithConstructor = new Eagle(eagle);
        System.out.println("Cloned with constructor: " + eagleClonedWithConstructor);

        Eagle eagleClonedWithFabric = Eagle.cloneFabricMethod(eagle);
        System.out.println("Cloned with fabric: " + eagleClonedWithFabric);

        Eagle eagleClonedWithReflection = Eagle.cloneWithReflection(eagle);
        System.out.println("Cloned with reflection: " + eagleClonedWithReflection);

        Eagle eagleClonedWithSerialization  = Eagle.cloneWithSerialization(eagle);
        System.out.println("Cloned with serialization: " + eagleClonedWithSerialization);
    }
}

import java.io.File
import javax.xml.bind.JAXBContext
import javax.xml.bind.Marshaller

fun main() {
    var miPerro = Animal()
    miPerro.nombre_propietario = "Manuel"
    miPerro.id = "100"
    miPerro.nombre_animal = "Boby"
    miPerro.coordenada.add("3,5")
    miPerro.coordenada.add("12,3")

    val miCachorro = Cachorro()
    miCachorro.nombreCachorro = "Bady"
    miCachorro.vacuna.add("Rabia")
    miCachorro.vacuna.add("Lismania")

    val miCachorro2 = Cachorro()
    miCachorro2.nombreCachorro = "Yedra"
    miCachorro2.vacuna.add("Rabia")

    val miCachorro3 = Cachorro()
    miCachorro3.nombreCachorro = "Pitufo"
    miCachorro3.vacuna.add("Lismania")
    miPerro.cachorro.add(miCachorro)
    miPerro.cachorro.add(miCachorro2)
    miPerro.cachorro.add(miCachorro3)


    //Configurar un JAXBContent para las clases
    val context= JAXBContext.newInstance(Animal::class.java)

    //Crear un Marshaller para serializar
    //Marshall = Guardar
    val mashaller = context.createMarshaller()
    mashaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true)
    val file = File("./animales.xml")

    //Guardar mi perro
    mashaller.marshal(miPerro,file)

    //Unmarshall = Recuperar
    val unmarshaller = context.createUnmarshaller()

    //Cargar animal de xml
    val animal_xml = unmarshaller.unmarshal(File("./animales.xml")) as Animal

    println(miPerro.nombre_animal)
    println(animal_xml.nombre_animal)
}
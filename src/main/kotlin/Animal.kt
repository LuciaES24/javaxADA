import javax.xml.bind.annotation.XmlAttribute
import javax.xml.bind.annotation.XmlElementWrapper
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement
class Animal {
    @get:XmlAttribute(name = "id")
    var id :String? = null

    var nombre_animal :String = ""
    var nombre_propietario :String = ""

    @get:XmlElementWrapper(name = "coordenadas")

    var coordenada = arrayListOf<String>()

    @get:XmlElementWrapper(name = "cachorros")
    var cachorro = arrayListOf<Cachorro>()
}
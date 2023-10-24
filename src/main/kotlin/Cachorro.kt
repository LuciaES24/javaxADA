import javax.xml.bind.annotation.XmlElementWrapper
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement
class Cachorro {
    var nombreCachorro = ""

    @get:XmlElementWrapper(name = "vacunas")
    var vacuna = arrayListOf<String>()
}
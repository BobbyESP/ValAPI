
import com.bobbyesp.valapi.library.domain.model.contracts.Content
import java.io.File
import kotlin.reflect.KClass

fun main() {
    val classesToGenerate = listOf(Content::class)

    for (clazz in classesToGenerate) {
        generateTypeConverter(clazz)
    }
}

fun generateTypeConverter(clazz: KClass<*>) {
    val packageName = clazz.java.`package`?.name
    val className = clazz.simpleName
    val typeConverterClassName = "${className}TypeConverters"

    val typeConverter = """
        package $packageName;
        
        import androidx.room.TypeConverter;
        import kotlinx.serialization.decodeFromString;
        import kotlinx.serialization.encodeToString;
        import kotlinx.serialization.json.Json;
        
        class $typeConverterClassName {
            val json = Json {
                ignoreUnknownKeys = true
                encodeDefaults = true
             };
            
            @TypeConverter
            fun fromJson(jsonString: String): ${clazz.qualifiedName} {
                return json.decodeFromString(jsonString);
            }

            @TypeConverter
            fun toJson(value: ${clazz.qualifiedName}): String {
                return json.encodeToString(value);
            }
            
            @TypeConverter
            fun fromJsonList(jsonString: String): List<${clazz.qualifiedName}> {
                return json.decodeFromString(jsonString);
            }

            @TypeConverter
            fun toJsonList(value: List<${clazz.qualifiedName}>): String {
                return json.encodeToString(value);
            }
        }
    """.trimIndent()

    val outputFile = File("library/src/main/java/com/bobbyesp/valapi/library/converters/$typeConverterClassName.kt")
    outputFile.parentFile?.mkdirs()
    outputFile.writeText(typeConverter)
}

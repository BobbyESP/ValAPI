
import com.bobbyesp.valapi.library.data.local.database.entity.SprayLevelEntity
import com.bobbyesp.valapi.library.domain.model.gamemodes.GameFeatureOverride
import com.bobbyesp.valapi.library.domain.model.gamemodes.GameRuleBoolOverride
import com.bobbyesp.valapi.library.domain.model.gear.Gear
import com.bobbyesp.valapi.library.domain.model.gear.ShopData
import com.bobbyesp.valapi.library.domain.model.maps.Callout
import com.bobbyesp.valapi.library.domain.model.seasons.competitive.Border
import com.bobbyesp.valapi.library.domain.model.weapons.SkinLevel
import com.bobbyesp.valapi.library.domain.model.weapons.WeaponStats
import com.bobbyesp.valapi.library.domain.model.weapons.skins.WeaponSkin
import com.bobbyesp.valapi.library.domain.model.weapons.skins.chromas.Chroma
import java.io.File
import kotlin.reflect.KClass

fun main() {
    val classesToGenerate = listOf(Callout::class, Border::class, SprayLevelEntity::class, WeaponSkin::class, WeaponStats::class, Chroma::class, SkinLevel::class)

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

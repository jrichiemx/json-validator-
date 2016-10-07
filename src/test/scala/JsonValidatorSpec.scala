
import com.eclipsesource.schema.{JsonSource, SchemaType, SchemaValidator}
import org.scalatest._
import play.api.libs.json.JsValue
import play.libs.Json

/**
 * Created by jrichiemx on 10/7/16.
 */
class JsonValidatorSpec extends FlatSpec with Matchers {
  "A json file " should "be Success validated against a schema" in {


    val schema = JsonSource.schemaFromStream(getClass.getResourceAsStream("test-schema.json")).get
    val json = Json.parse(getClass.getResourceAsStream("test1.json"))
    val validator = SchemaValidator()

    assert( validator.validate(schema, json).isSuccess )

  }

  it should "be Unsuccess validated against a schema" in {


    val schema = JsonSource.schemaFromStream(getClass.getResourceAsStream("test-schema.json")).get
    val json = Json.parse(getClass.getResourceAsStream("test2.json"))
    val validator = SchemaValidator()

    assert( validator.validate(schema, json).isError )

  }
}

#language: en
@testProductStore
Feature: Product - Store

  @test
  Scenario Outline: Validación del precio de un producto
    Given estoy en la página de la tienda
    And me logueo con mi usuario "<user>" y clave "<password>"
    When navego a la categoria "<category>" y subcategoria "<subcategory>"
    And agrego 2 unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado
    And valido en el popup que el monto total sea calculado correctamente
    When finalizo la compra
    Then valido el titulo de la pagina del carrito
    And vuelvo a validar el calculo de precios en el carrito
    Examples:
      | user                     | password            | category | subcategory |
      | j-ken2014@hotmail.com    | T$&BdS/>3}@Gxmw>    | Clothes  | Men         |
      | kevin@hotmail.com        | Password*1234       | Clothes  | Men         |
      | j-ken2014@hotmail.com    | T$&BdS/>3}@Gxmw>    | Autos    | Audi        |
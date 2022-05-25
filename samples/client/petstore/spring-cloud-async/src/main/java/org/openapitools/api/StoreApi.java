/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.0.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import java.util.Map;
import org.openapitools.model.Order;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
@Api(value = "Store", description = "Access to Petstore orders")
public interface StoreApi {

    /**
     * DELETE /store/order/{orderId} : Delete purchase order by ID
     * For valid response try integer IDs with value &lt; 1000. Anything above 1000 or nonintegers will generate API errors
     *
     * @param orderId ID of the order that needs to be deleted (required)
     * @return Invalid ID supplied (status code 400)
     *         or Order not found (status code 404)
     */
    @ApiOperation(
        tags = { "store" },
        value = "Delete purchase order by ID",
        nickname = "deleteOrder",
        notes = "For valid response try integer IDs with value < 1000. Anything above 1000 or nonintegers will generate API errors"
    )
    @ApiResponses({
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Order not found")
    })
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/store/order/{orderId}"
    )
    CompletableFuture<ResponseEntity<Void>> deleteOrder(
        @ApiParam(value = "ID of the order that needs to be deleted", required = true) @PathVariable("orderId") String orderId
    );


    /**
     * GET /store/inventory : Returns pet inventories by status
     * Returns a map of status codes to quantities
     *
     * @return successful operation (status code 200)
     */
    @ApiOperation(
        tags = { "store" },
        value = "Returns pet inventories by status",
        nickname = "getInventory",
        notes = "Returns a map of status codes to quantities",
        response = Integer.class,
        responseContainer = "Map",
        authorizations = {
            @Authorization(value = "api_key")
         }
    )
    @ApiResponses({
        @ApiResponse(code = 200, message = "successful operation", response = Map.class, responseContainer = "Map")
    })
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/store/inventory",
        produces = "application/json"
    )
    CompletableFuture<ResponseEntity<Map<String, Integer>>> getInventory(
        
    );


    /**
     * GET /store/order/{orderId} : Find purchase order by ID
     * For valid response try integer IDs with value &lt;&#x3D; 5 or &gt; 10. Other values will generated exceptions
     *
     * @param orderId ID of pet that needs to be fetched (required)
     * @return successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Order not found (status code 404)
     */
    @ApiOperation(
        tags = { "store" },
        value = "Find purchase order by ID",
        nickname = "getOrderById",
        notes = "For valid response try integer IDs with value <= 5 or > 10. Other values will generated exceptions",
        response = Order.class
    )
    @ApiResponses({
        @ApiResponse(code = 200, message = "successful operation", response = Order.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Order not found")
    })
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/store/order/{orderId}",
        produces = "application/json"
    )
    CompletableFuture<ResponseEntity<Order>> getOrderById(
        @Min(1L) @Max(5L) @ApiParam(value = "ID of pet that needs to be fetched", required = true) @PathVariable("orderId") Long orderId
    );


    /**
     * POST /store/order : Place an order for a pet
     *
     * @param body order placed for purchasing the pet (required)
     * @return successful operation (status code 200)
     *         or Invalid Order (status code 400)
     */
    @ApiOperation(
        tags = { "store" },
        value = "Place an order for a pet",
        nickname = "placeOrder",
        notes = "",
        response = Order.class
    )
    @ApiResponses({
        @ApiResponse(code = 200, message = "successful operation", response = Order.class),
        @ApiResponse(code = 400, message = "Invalid Order")
    })
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/store/order",
        produces = "application/json"
    )
    CompletableFuture<ResponseEntity<Order>> placeOrder(
        @ApiParam(value = "order placed for purchasing the pet", required = true) @Valid @RequestBody Order body
    );

}

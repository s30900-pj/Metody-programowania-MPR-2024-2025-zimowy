package pl.edu.pjwstk.s30900.s30900OrderService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderStorage orderStorage;

    @Mock
    private ProductsStorage productsStorage;

    @InjectMocks
    private OrderService orderService;

    @Test
    void addProductToOrder_OrderDoesNotExist_PrintsErrorMessage() {
        // Arrange
        Long orderId = 1L;
        Product product = new Product(orderId,"TestProduct", 10);
        int quantity = 2;

        // Mocking
        when(orderStorage.getOrder(eq(orderId))).thenReturn(null);

        // Act
        orderService.addProductToOrder(orderId, product, quantity);

        // Verify
        verify(orderStorage, times(1)).getOrder(eq(orderId));
        verifyNoMoreInteractions(orderStorage);
    }
    @Test
    void removeProductFromOrder_OrderExists_CallsRemoveProduct() {
        // Arrange
        Long orderId = 1L;
        Product product = new Product(orderId, "TestProduct", 10);

        // Mocking
        Order existingOrder = mock(Order.class);

        when(orderStorage.getOrder(eq(orderId))).thenReturn(existingOrder);

        // Act
        orderService.removeProductFromOrder(orderId, product);

        // Verify
        verify(orderStorage, times(1)).getOrder(eq(orderId));
        verify(existingOrder, times(1)).removeProduct(eq(product)); // Weryfikujemy metodę removeProduct na mocku existingOrder
        verifyNoMoreInteractions(orderStorage, existingOrder);
    }
}

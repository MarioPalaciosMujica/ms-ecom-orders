package com.ecom.order.services;

import com.ecom.order.dalc.entities.PaymentMethod;
import com.ecom.order.dalc.entities.PaymentStatus;
import com.ecom.order.dalc.entities.PurchaseOrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MockService {

    @Autowired private PaymentMethodService paymentMethodService;
    @Autowired private PaymentStatusService paymentStatusService;
    @Autowired private PurchaseOrderStatusService purchaseOrderStatusService;

    public void start(){
        this.mockPaymentStatuses();
        this.mockPurchaseOrderStatuses();
    }

    private void mockPaymentStatuses(){
        if(paymentMethodService.findAll().size() == 0){
            PaymentMethod webpay = new PaymentMethod(null, "WP_PLUS", "Webpay Plus", null);
            webpay = paymentMethodService.save(webpay);

            if(paymentStatusService.findAll().size() == 0){
                PaymentStatus pendiente = new PaymentStatus(null, "Transacción Pendiente", "PP", false, null, null);
                PaymentStatus noEncontrado = new PaymentStatus(null, "Status Invalido", "NS", false, null, null);
                PaymentStatus wpAprobada = new PaymentStatus(null, "Transacción Aprobada", "0", true, webpay, null);
                PaymentStatus wpRechazo1 = new PaymentStatus(null, "Rechazo de Transacción", "-1", false, webpay, null);
                PaymentStatus wpRechazo2 = new PaymentStatus(null, "Rechazo de Transacción", "-2", false, webpay, null);
                PaymentStatus wpError = new PaymentStatus(null, "Error de Transacción", "-3", false, webpay, null);
                PaymentStatus wpRechazoEmisor = new PaymentStatus(null, "Rechazo de Emisor", "-4", false, webpay, null);
                PaymentStatus wpFraude = new PaymentStatus(null, "Rechazo por Posible Fraude", "-5", false, webpay, null);

                paymentStatusService.save(pendiente);
                paymentStatusService.save(noEncontrado);
                paymentStatusService.save(wpAprobada);
                paymentStatusService.save(wpRechazo1);
                paymentStatusService.save(wpRechazo2);
                paymentStatusService.save(wpError);
                paymentStatusService.save(wpRechazoEmisor);
                paymentStatusService.save(wpFraude);
            }
        }
    }

    private void mockPurchaseOrderStatuses(){
        if(purchaseOrderStatusService.findAll().size() == 0){
            PurchaseOrderStatus posPagoPend = new PurchaseOrderStatus(null, "PP","Págo Pendiente",
                    "El cliente aún no realiza la transacción de págo.", 1, false, null);

            PurchaseOrderStatus posOrdenCancel = new PurchaseOrderStatus(null, "OC","Orden Cancelada",
                    "El cliente a cancelado la orden de compra antes de hacer la transacción.", 1, false, null);

            PurchaseOrderStatus posAtencionPend = new PurchaseOrderStatus(null, "AP","Atención Pendiente",
                    "El cliente ya realizó la transacción.", 2, true, null);

            PurchaseOrderStatus posElaboracion = new PurchaseOrderStatus(null, "EB","En Elaboración",
                    "El o los productos se encuentran en elaboración.", 3, true, null);

            PurchaseOrderStatus posListoRetiro = new PurchaseOrderStatus(null, "LR","Listo para Retiro",
                    "El o los producto están listos para hacer el retiro en sucursal.", 4, true, null);

            PurchaseOrderStatus posListoDelivery = new PurchaseOrderStatus(null, "LD", "Listo para Delivery",
                    "El o los producto está listo para la entrega a destino.", 4, true, null);

            PurchaseOrderStatus posDelivery = new PurchaseOrderStatus(null, "DV","En Delivery",
                    "El o los productos se encuentran en camino al destino del cliente.", 5, true, null);

            PurchaseOrderStatus posCompletado = new PurchaseOrderStatus(null, "CD","Completado",
                    "El cliente ya recibió el o los productos. Servicio completado.", 6, true, null);

            purchaseOrderStatusService.save(posPagoPend);
            purchaseOrderStatusService.save(posOrdenCancel);
            purchaseOrderStatusService.save(posAtencionPend);
            purchaseOrderStatusService.save(posElaboracion);
            purchaseOrderStatusService.save(posListoRetiro);
            purchaseOrderStatusService.save(posListoDelivery);
            purchaseOrderStatusService.save(posDelivery);
            purchaseOrderStatusService.save(posCompletado);
        }
    }
}

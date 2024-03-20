/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.andriamalalafranckie.tp1.jsf;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
import mg.itu.andriamalalafranckie.tp1.entity.Discount;
import mg.itu.andriamalalafranckie.tp1.service.DiscountManager;

/**
 * Convertisseur JSF pour les Discount
 *
 * @author andriamalala
 */
@FacesConverter(value = "discountConverter", managed = true)
public class DiscountConverter implements Converter<Discount> {

    @Inject
    private DiscountManager discountManager;

    /**
     * Convertit une String en Discount
     *
     * @param fc
     * @param uic
     * @param value
     * @return
     */
    @Override
    public Discount getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value == null) {
            return null;
        }
        return discountManager.findById(value);
    }

    /**
     * Convertit un Discount en String
     *
     * @param fc
     * @param uic
     * @param discount
     * @return
     */
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Discount discount) {
        if (discount == null) {
            return "";
        }
        return discount.getCode();
    }

}

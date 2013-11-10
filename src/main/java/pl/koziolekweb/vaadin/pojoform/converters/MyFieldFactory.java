package pl.koziolekweb.vaadin.pojoform.converters;

import com.vaadin.data.fieldgroup.DefaultFieldGroupFieldFactory;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroupFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.UI;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 09.11.13
 * Time: 13:47
 * To change this template use File | Settings | File Templates.
 */
public class MyFieldFactory implements FieldGroupFieldFactory {
	private DefaultFieldGroupFieldFactory dff = new DefaultFieldGroupFieldFactory();

	@Override
	public <T extends Field> T createField(Class<?> dataType, Class<T> fieldType) {
		T field = dff.createField(dataType, fieldType);
		if (field == null) {
			try {
				field = fieldType.newInstance();
			} catch (Exception e) {
				throw new FieldGroup.BindException("Could not create a field of type "
						+ fieldType, e);
			}
		}
		return field;
	}
}

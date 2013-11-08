package pl.koziolekweb.vaadin.pojoform.converters;

import com.vaadin.data.util.converter.Converter;
import com.vaadin.data.util.converter.ConverterFactory;
import com.vaadin.data.util.converter.DefaultConverterFactory;
import org.apache.commons.collections.map.MultiKeyMap;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 08.11.13
 * Time: 19:26
 * To change this template use File | Settings | File Templates.
 */
public class MyConverterFactory extends DefaultConverterFactory {

	MultiKeyMap additionalConverters = new MultiKeyMap();

	public <PRESENTATION, MODEL> void addConverter(Converter<PRESENTATION, MODEL> converter) {
		additionalConverters.put(converter.getPresentationType(), converter.getModelType(), converter);
	}

	@Override
	public <PRESENTATION, MODEL> Converter<PRESENTATION, MODEL> createConverter(Class<PRESENTATION> presentationClass, Class<MODEL> modelClass) {
		Converter<PRESENTATION, MODEL> converter = createConverter(presentationClass, modelClass);
		if (converter == null) {
			converter = (Converter<PRESENTATION, MODEL>) additionalConverters.get(presentationClass, modelClass);
		}
		return converter;
	}
}

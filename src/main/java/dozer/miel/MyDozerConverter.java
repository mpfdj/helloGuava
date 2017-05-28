package dozer.miel;

import org.dozer.DozerConverter;

public class MyDozerConverter extends DozerConverter<String, Boolean> {

    public MyDozerConverter() {
        super(String.class, Boolean.class);
    }

    @Override
    public Boolean convertTo(String source, Boolean destination) {
        if ("yes".equals(source)) {
            return Boolean.TRUE;
        } else if ("no".equals(source)) {
            return Boolean.FALSE;
        }
        throw new IllegalStateException("Unknown value!");
    }

    @Override
    public String convertFrom(Boolean source, String destination) {
        if (Boolean.TRUE.equals(source)) {
            return "yes";
        } else if (Boolean.FALSE.equals(source)) {
            return "no";
        }
        throw new IllegalStateException("Unknown value!");
    }

}
package forms;

import images.Image;

public class FormsGenerator {
    private Integer numberForm ;
    forms form ;

    public forms getForm(){
        switch (generateNewRandomNumber()){
            case 0:
                return form=new forms(Image.CUADRADO.toString(), 14,5,numberForm);
            case 1:
                return form=new forms(Image.I.getNameImages(),12,5,numberForm);
            case 2:
                return form=new forms(Image.L.getNameImages(), 13,5,numberForm);
            case 3:
                return form=new forms(Image.LINVERTIDA.getNameImages(), 13,5,numberForm);
            case 4:
                return form=new forms(Image.S.getNameImages(), 13,5,numberForm);
            case 5:
                return form=new forms(Image.SINVERTIDA.getNameImages(), 13,5,numberForm);
            case 6:
                return form=new forms(Image.T.getNameImages(), 14,5,numberForm);
            default:
                return null;
        }
    }

    public Integer generateNewRandomNumber(){
        return this.numberForm = (int) (Math.random()*7);
    }

    public FormsGenerator(){
        numberForm = (int) (Math.random()*7);
    }

}

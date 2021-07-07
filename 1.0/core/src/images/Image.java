package images;

public enum Image {

    BLOCKBACKGROUND("background/blockBackground.png"),
    POORBACKGROUND("background/alphaStage.png"),
    CUADRADO("forms/CUADRADO.png"),
    I("forms/I.png"),
    L("forms/L.png"),
    LINVERTIDA("forms/LINVERTED.png"),
    S("forms/S.png"),
    SINVERTIDA("forms/SINVERTED.png"),
    T("forms/T.png");

    private String nameImages ;

    private Image(String nameImages ){this.nameImages = nameImages ;}

    public String getNameImages(){ return nameImages; }

    public String toString(){
        return nameImages;
    }

}

public class Sesion {
    private Pelicula peliSesion;
    private String horaInicio;
    private int entradasVendidas;
    private int entradasTotales;

    public Sesion(Pelicula peliSesion, String horaInicio) {
        this.peliSesion = peliSesion;
        this.horaInicio = horaInicio;
        this.entradasVendidas =0;
        this.entradasTotales = 50;
    }

    public Pelicula getPeliSesion() {
        return peliSesion;
    }

    public void setPeliSesion(Pelicula peliSesion) {
        this.peliSesion = peliSesion;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getEntradasVendidas() {
        return entradasVendidas;
    }

    public void setEntradasVendidas(int entradasVendidas) {
        this.entradasVendidas = entradasVendidas;
    }

    public int getEntradasTotales() {
        return entradasTotales;
    }

    public void setEntradasTotales(int entradasTotales) {
        this.entradasTotales = entradasTotales;
    }

    public void comprar(int cantidad){
        setEntradasVendidas(this.entradasVendidas+cantidad);
    }


    @Override
    public String toString() {
        int entradasRestantes=this.entradasTotales-this.entradasVendidas;
        return "Sesion: " + peliSesion.getNombre() + "--> " + horaInicio + "\n Entradas Vendidas: "
                + entradasVendidas + "\n EntradasTotales: " + entradasTotales + "\n Entradas Restantes: "+entradasRestantes;
    }

    

}

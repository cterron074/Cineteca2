public class Pelicula {
    private String nombre;
    private String director;
    private int duracionMins;
    
    public Pelicula(String nombre, String director, int duracionMins) {
        this.nombre = nombre;
        this.director = director;
        this.duracionMins = duracionMins;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuracionMins() {
        return duracionMins;
    }

    public void setDuracionMins(int duracionMins) {
        this.duracionMins = duracionMins;
    }

    @Override
    public String toString() {
        return "----"+nombre +"----"+ "\n --> Director:" + director + "\n ---> Duracion en Minutoss=" + duracionMins ;
    }

    


}

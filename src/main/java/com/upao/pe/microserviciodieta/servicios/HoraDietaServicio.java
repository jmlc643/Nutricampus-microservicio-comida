package com.upao.pe.microserviciodieta.servicios;


public class HoraDietaServicio {
/*
    @Autowired private HoraDietaRepositorio horaDietaRepositorio;
    @Autowired private DietaServicio dietaServicio;
    @Autowired private HoraDiaServicio horaDiaServicio;

    // READ
    public List<HoraDietaSerializer> listarHoraDietas(){return horaDietaRepositorio.findAll().stream().map(this::retornarHoraDietaSerializer).toList();}

    // CREATE
    public HoraDietaSerializer crearHoraDieta(CrearHoraDietaSerializer request){
        HoraDia horaDia = horaDiaServicio.buscarHoraDia(request.getMomentoDia());
        Dieta dieta = dietaServicio.buscarDieta(request.getIdDieta());
        HoraDieta horaDieta =new HoraDieta(null, request.getHora(), dieta, horaDia);
        return retornarHoraDietaSerializer(horaDietaRepositorio.save(horaDieta));
    }

    // DELETE
    public List<HoraDietaSerializer> eliminarHoraDieta(Long id){
        HoraDieta horaDieta = buscarHoraDietaPorId(id);
        horaDietaRepositorio.delete(horaDieta);
        return listarHoraDietas();
    }

    public HoraDieta buscarHoraDietaPorId(Long id) {
        Optional<HoraDieta> horaDieta = horaDietaRepositorio.findById(id);
        if(horaDieta.isEmpty()){
            throw new RuntimeException("No se encuentra la hora de la dieta");
        }
        return horaDieta.get();
    }
    
    public HoraDietaSerializer retornarHoraDietaSerializer(HoraDieta horaDieta){
        return new HoraDietaSerializer(horaDieta.getHora(), dietaServicio.retornarDietaSerializer(horaDieta.getDieta()), horaDiaServicio.retornarHoraDiaSerializer(horaDieta.getHoraDia()));
    }

 */
}

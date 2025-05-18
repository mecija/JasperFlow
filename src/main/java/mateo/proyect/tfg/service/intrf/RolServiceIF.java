package mateo.proyect.tfg.service.intrf;

import mateo.proyect.tfg.models.db.RolDB;

public interface RolServiceIF {

    public RolDB create(RolDB obj);
    public RolDB read(Integer id);
    public RolDB update(Integer id, RolDB obj);
    public void delete(Integer id);

}
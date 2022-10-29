package co.com.softcol.softcol.model;

import java.sql.Date;
import java.util.TimeZone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name="citas")
public class citasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idcitas;
    private int paciente;
    private int médico;
    private int tipo;
    private Date fecha;
    private TimeZone hora;
    private String Estado;
}

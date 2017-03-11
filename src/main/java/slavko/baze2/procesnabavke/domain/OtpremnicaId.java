package slavko.baze2.procesnabavke.domain;

import lombok.ToString;

import java.io.Serializable;

/**
 * @author Sinisa Komarica
 */
@ToString
public class OtpremnicaId implements Serializable {

    private Long sifraDobavljaca;

    private Long brojOtpremnice;

    public OtpremnicaId() {

    }

    public OtpremnicaId(Long sifraDobavljaca, Long brojOtpremnice) {
        this.sifraDobavljaca = sifraDobavljaca;
        this.brojOtpremnice = brojOtpremnice;
    }

    public Long getSifraDobavljaca() {
        return sifraDobavljaca;
    }

    public void setSifraDobavljaca(Long sifraDobavljaca) {
        this.sifraDobavljaca = sifraDobavljaca;
    }

    public Long getBrojOtpremnice() {
        return brojOtpremnice;
    }

    public void setBrojOtpremnice(Long brojOtpremnice) {
        this.brojOtpremnice = brojOtpremnice;
    }
}

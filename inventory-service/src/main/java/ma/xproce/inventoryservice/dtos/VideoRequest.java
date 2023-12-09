package ma.xproce.inventoryservice.dtos;

import java.util.Date;
import java.util.List;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VideoRequest {
    private String name;
    private String url;
    private String description;
    private Date datePublication;
    private CreatorRequest creator;
}

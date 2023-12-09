package ma.xproce.inventoryservice.mapper;

import ma.xproce.inventoryservice.dtos.CreatorRequest;
import ma.xproce.inventoryservice.dtos.VideoRequest;
import ma.xproce.inventoryservice.entities.Creator;
import ma.xproce.inventoryservice.entities.Video;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class VideoMapper {
    public Video fromVideoRequest(VideoRequest videoRequest){
        Video video = new Video();
        BeanUtils.copyProperties(videoRequest, video);
        video.setCreator(this.fromCreatorRequest(videoRequest.getCreator()));
        return video;
    }

    public Creator fromCreatorRequest(CreatorRequest creatorRequest){
        Creator creator = new Creator();
        BeanUtils.copyProperties(creatorRequest, creator);
        return creator;
    }

}

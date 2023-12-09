package ma.xproce.inventoryservice.web;

import lombok.AllArgsConstructor;
import ma.xproce.inventoryservice.dtos.CreatorRequest;
import ma.xproce.inventoryservice.dtos.VideoRequest;
import ma.xproce.inventoryservice.entities.Creator;
import ma.xproce.inventoryservice.entities.Video;
import ma.xproce.inventoryservice.mapper.VideoMapper;
import ma.xproce.inventoryservice.repositories.CreatorRepository;
import ma.xproce.inventoryservice.repositories.VideoRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
@AllArgsConstructor
public class VideoGraphQlController {
    private CreatorRepository creatorRepository;
    private VideoRepository videoRepository;
    private VideoMapper videoMapper;

    @QueryMapping
    public List<Video> videoList(){
        return videoRepository.findAll();
    }

    @QueryMapping
    public Creator creator(@Argument Long id){
        return creatorRepository.findById(id).get();
    }

    @MutationMapping
    public Creator saveCreator(@Argument CreatorRequest creator){
        Creator creator1 = videoMapper.fromCreatorRequest(creator);
        return creatorRepository.save(creator1);
    }

    @MutationMapping
    public Video saveVideo(@Argument VideoRequest video){
        Video video1 = videoMapper.fromVideoRequest(video);
        System.out.println(video1);
        Creator creator = creatorRepository.save(video1.getCreator());
        video1.setCreator(creator);

       // CreatorRequest creatorRequest = video.getCreatorRequest();
       // Creator creator = videoMapper.fromCreatorRequest(creatorRequest);

       // Creator savedCreator = creatorRepository.save(creator);
       // Video video1 = videoMapper.fromVideoRequest(video);
       //  video1.setCreator(savedCreator);

        return videoRepository.save(video1);
    }
}

package bootproject.peaksoft.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import bootproject.peaksoft.entities.Video;
import bootproject.peaksoft.service.VideoService;

@Controller
public class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("/videos/{id}")
    public String getAllVideo(@PathVariable Long id, Model model) {
        model.addAttribute("videos", videoService.getAllVideo());
        model.addAttribute("lessonId", id);
        return "video/videos";
    }

    @GetMapping("/videos/{id}/addVideo")
    public String addVideo(@PathVariable Long id, Model model){
        model.addAttribute("video", new Video());
        model.addAttribute("lessonId", id);
        return "video/addVideo";
    }

    @PostMapping("/{id}/saveVideo")
    public String saveVideo(@ModelAttribute("video") Video video,
                            @PathVariable Long id){
        videoService.addVideo(id, video);
        return "redirect:/videos/" + id;
    }

    @GetMapping("/updateVideo/{id}")
    public String updateVideo(@PathVariable("id") Long id, Model model){
        Video video = videoService.getVideoById(id);
        model.addAttribute("video", video);
        model.addAttribute("lessonId", video.getLesson().getId());
        return "video/updateVideo";
    }

    @PostMapping("/{lessonId}/{id}/saveUpdateVideo")
    public String saveUpdateVideo(@PathVariable("lessonId") Long lessonId,
                                  @PathVariable("id") Long id,
                                  @ModelAttribute("video") Video video) {
        videoService.updateVideo(video, id);
        return "redirect:/videos/" + lessonId;
    }

    @GetMapping("/{lessonId}/{id}/deleteVideo")
    private String deleteVideo(@PathVariable("lessonId") Long lessonId,@PathVariable("id") Long id) {
        videoService.deleteVideo(id);
        return "redirect:/videos/" + lessonId;
    }
}

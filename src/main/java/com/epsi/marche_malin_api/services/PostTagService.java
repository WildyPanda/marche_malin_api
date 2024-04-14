package com.epsi.marche_malin_api.services;

import com.epsi.marche_malin_api.entities.Image;
import com.epsi.marche_malin_api.entities.PostTag;
import com.epsi.marche_malin_api.entities.Posts;
import com.epsi.marche_malin_api.entities.Tags;
import com.epsi.marche_malin_api.repositories.PostTagRepo;
import com.epsi.marche_malin_api.repositories.TagsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PostTagService {
    @Autowired
    PostTagRepo postTagRepo;

    @Autowired
    TagsRepo tagsRepo;

    public void DeleteAllByPost(Posts post){
        List<PostTag> postTags = postTagRepo.findAllByIdPost(post);
        for(PostTag postTag : postTags){
            postTagRepo.delete(postTag);
        }
    }

    public List<Tags> GetByTag(String tagInput){
        return tagsRepo.findByNomTag(tagInput);
    }

    public List<Posts> findByTag(List<String> tags) {

        List<Posts> postsWithAllTags = new ArrayList<>();
            List<PostTag> listEntity = postTagRepo.findAll();
            for (PostTag postTag : listEntity) {

                int nbTag = tags.size();
                int corresponding = 0;

                Posts post = postTag.getId().getPost();
                List<PostTag> postTagsList = postTagRepo.findAllByIdPost(post);
                List<Tags> listTags = new ArrayList<>();
                for (PostTag i : postTagsList) {
                    listTags.add(i.getId().getTag());
                }
                int size = listTags.size();
                for (Tags tag : listTags) {
                    for (String tag2Name : tags) {
                        if (Objects.equals(tag.getNameTag(), tag2Name)) {
                            corresponding ++;
                        }
                    }
                }
                if (nbTag == corresponding){
                    if(!(postsWithAllTags.contains(post))) {
                        postsWithAllTags.add(post);
                    }
                }
            }

        return postsWithAllTags;
    }
}

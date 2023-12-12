package com.example.demo.Service;
import com.example.demo.Dto.InnerCommentsDto;
import com.example.demo.Entity.InnerComments;
import com.example.demo.Repository.InnerCommentsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InnerCommentsServiceImpl implements InnerCommentsService{

    @Autowired
    private InnerCommentsRepository innerCommentsRepository;

    private ModelMapper modelMapper;
    public InnerCommentsServiceImpl() {modelMapper = new ModelMapper();}
    @Override
    public List<InnerCommentsDto> getAllInnerComments() {
        List<InnerComments> innerComments = innerCommentsRepository.findAll();
        return innerComments.stream().map(innerComment -> modelMapper.map(innerComment, InnerCommentsDto.class)).collect(Collectors.toList());
    }

    @Override
    public InnerCommentsDto getByCommentsId(int innerCommentId) {
        Optional<InnerComments> commentsOptional = innerCommentsRepository.findById(innerCommentId);
        return commentsOptional.map(comments -> modelMapper.map(comments,InnerCommentsDto.class)).orElse(null);
    }
    @Override
    public InnerCommentsDto saveComments(InnerCommentsDto innerCommentsDto) {
        InnerComments comments = modelMapper.map(innerCommentsDto,InnerComments.class);
        InnerComments saveComments = innerCommentsRepository.save(comments);
        return modelMapper.map(saveComments,InnerCommentsDto.class);
    }

    @Override
    public InnerCommentsDto updateComments(int innerCommentId, InnerCommentsDto innerCommentsDto) {
        Optional<InnerComments> commentsOptional = innerCommentsRepository.findById(innerCommentId);
        if(commentsOptional.isPresent()){
            InnerComments existingCommit = commentsOptional.get();
            if(innerCommentsDto.getComments()!=null){
                existingCommit.setComments(innerCommentsDto.getComments());
            }
            InnerComments updateComment = innerCommentsRepository.save(existingCommit);
            return modelMapper.map(updateComment,InnerCommentsDto.class);
        }else {
            return null;
        }
    }

    @Override
    public void deleteById(int innerCommentId) {
    innerCommentsRepository.deleteById(innerCommentId);
    }
}

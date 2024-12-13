package com.hikmetsuicmez.notebookapp.mapper;

import com.hikmetsuicmez.notebookapp.dto.request.NoteRequest;
import com.hikmetsuicmez.notebookapp.dto.response.NoteResponse;
import com.hikmetsuicmez.notebookapp.model.Note;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NoteMapper {

        NoteMapper INSTANCE = Mappers.getMapper( NoteMapper.class );

        @Mapping( target = "category.id", source = "categoryId")
        Note toEntity(NoteRequest noteRequest);

        @Mapping( target = "categoryName", source = "category.name")
        NoteResponse toResponse(Note note);
}

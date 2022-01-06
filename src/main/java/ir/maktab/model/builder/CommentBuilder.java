package ir.maktab.model.builder;

import ir.maktab.model.entity.Comment;
import ir.maktab.model.entity.Instruction;

public final class CommentBuilder {
    private Integer id;
    private Double score;
    private String opinion;
    private Instruction instruction;

    private CommentBuilder() {
    }

    public static CommentBuilder aComment() {
        return new CommentBuilder();
    }

    public CommentBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public CommentBuilder withScore(Double score) {
        this.score = score;
        return this;
    }

    public CommentBuilder withOpinion(String opinion) {
        this.opinion = opinion;
        return this;
    }

    public CommentBuilder withInstruction(Instruction instruction) {
        this.instruction = instruction;
        return this;
    }

    public Comment build() {
        Comment comment = new Comment();
        comment.setId(id);
        comment.setScore(score);
        comment.setOpinion(opinion);
        comment.setInstruction(instruction);
        return comment;
    }
}

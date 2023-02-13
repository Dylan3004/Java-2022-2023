public interface Movable {

    void MoveTo(Possition possition, Word world) throws OutsiteTheWorldException;
    void MoveBack();
}

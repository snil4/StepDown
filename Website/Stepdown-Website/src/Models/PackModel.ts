import SongModel from "./SongModel";

class PackModel {
    id!: number;
    uploader!: string;
    songs?: SongModel[];
    imageName!: string;
}

export default PackModel;
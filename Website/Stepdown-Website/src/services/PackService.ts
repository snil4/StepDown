import axios from "axios";
import config from "../Util/config";
import PackModel from "../Models/PackModel";

class PackService {
    public async getSong(packId: number): Promise<PackModel> {
        const response = await axios.get(`${config.packURL}${packId}`);
        return response.data;
    }

    public async getAllSongs(): Promise<PackModel[]> {
        const response = await axios.get(`${config.packURL}all`);
        return response.data;
    }

    public async addSong(pack: PackModel) {
        const response = await axios.post(`${config.packURL}`, pack);
        return response.data;
    }

    public async updateSong(pack: PackModel) {
        const response = await axios.put(`${config.packURL}`, pack);
        return response.data;
    }

    public async deleteSong(packId: number) {
        const response = await axios.delete(`${config.packURL}${packId}`);
        return response.data;
    }
}

export default PackService;
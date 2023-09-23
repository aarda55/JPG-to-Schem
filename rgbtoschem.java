import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.plugin.java.JavaPlugin;

public class rgbtoschem {
 public Material findClosestBlockMaterial(int red, int green, int blue) {
        Material closestMaterial = null;
        double closestDistance = Double.MAX_VALUE;
        
        for (Material material : Material.values()) {
            if (material.isBlock() && material.isSolid()) {
                BlockData blockData = material.createBlockData();
                int blockRed = blockData.getColor().asRGB() >> 16 & 0xFF;
                int blockGreen = blockData.getColor().asRGB() >> 8 & 0xFF;
                int blockBlue = blockData.getColor().asRGB() & 0xFF;
                
                double distance = Math.sqrt(
                        Math.pow(red - blockRed, 2) +
                        Math.pow(green - blockGreen, 2) +
                        Math.pow(blue - blockBlue, 2)
                );
                
                if (distance < closestDistance) {
                    closestDistance = distance;
                    closestMaterial = material;
                }
            }
        }
        return closestMaterial;
    }
}

using Microsoft.EntityFrameworkCore;

namespace StepDown.Models;
public class ChartContext: DbContext {
    public ChartContext(DbContextOptions<ChartContext> options) : base(options) {
        this.Database.EnsureCreated();
    }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder) {
        optionsBuilder.UseMySQL("server=localhost;database=song_db;user=root;password=12345678");
    }

    protected override void OnModelCreating(ModelBuilder modelBuilder) {
        base.OnModelCreating(modelBuilder);

        modelBuilder.Entity<Chart>(entity => {
            entity.HasKey(e => e.id);
            entity.Property(e => e.difficulty);
            entity.Property(e => e.level);
            entity.Property(e => e.name);
            entity.Property(e => e.author);
            entity.HasOne(e => e.song).WithMany(e => e.charts)
            .HasForeignKey(e => e.songId).HasPrincipalKey(e => e.id);
        });
    }
}
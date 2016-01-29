        final Player player = event.getPlayer();
        new BukkitRunnable(){
            double t = Math.PI;
            @Override
            public void run() {
                t = t - 0.05 * Math.PI;
                if(t < 0){
                    t = Math.PI;
                }
                HashMap<Integer, ParticleEffect.ParticleColor> colors = new HashMap<Integer, ParticleEffect.ParticleColor>();
                colors.put(1, new ParticleEffect.OrdinaryColor(Color.RED));
                colors.put(2, new ParticleEffect.OrdinaryColor(Color.ORANGE));
                colors.put(3, new ParticleEffect.OrdinaryColor(Color.YELLOW));
                colors.put(4, new ParticleEffect.OrdinaryColor(Color.GREEN));
                colors.put(5, new ParticleEffect.OrdinaryColor(Color.AQUA));
                colors.put(6, new ParticleEffect.OrdinaryColor(Color.BLUE));
                colors.put(7, new ParticleEffect.OrdinaryColor(Color.PURPLE));
                double xr = 5;
                double yr = 4;
                for(int i = 1; i < 8; i++){
                    Location l = player.getLocation();
                    l.add(xr * Math.cos(t), yr * Math.sin(t), 0);
                    ParticleEffect.ParticleColor color = colors.get(i);
                    assert color != null;
                    for(int a = 0; a < 10; a++){
                        ParticleEffect.SPELL_MOB.display(color, l, 16D);
                    }
                    l.subtract(xr * Math.cos(t), yr * Math.sin(t), 0);
                    xr -= 0.2;
                    yr -= 0.2;
                }
            }
        }.runTaskTimer(this, 0, 1);
